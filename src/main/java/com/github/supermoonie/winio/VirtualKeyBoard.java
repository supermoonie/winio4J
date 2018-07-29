/*
 * Copyright @ 2018 supermoonie
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.supermoonie.winio;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.WString;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author supermoonie
 * @date 2018/7/27
 */
public class VirtualKeyBoard {
    private static final WinIo WIN_IO = WinIo.INSTANCE;

    private static final String HOME = System.getProperty("user.home");

    private static final String WIN_IO_HOME = HOME + File.separator + "Desktop" + File.separator + "WinIo";

    private static final String WIN_32_SYS = "WinIo32.sys";

    private static final String WIN_64_SYS = "WinIo64.sys";

    private static final String WIN_IO_INSTALLER = "WinIoInstall.exe";

    static {
        String x86 = "x86";
        String driverName;
        File winIoHome = new File(WIN_IO_HOME);
        if (!winIoHome.exists()) {
            if (!winIoHome.mkdir()) {
                throw new IllegalStateException("Cannot Make Directory " + WIN_IO_HOME);
            }
        }
        if (x86.equals(WinIo.ARCH)) {
            driverName = WIN_IO_HOME + File.separator + WIN_32_SYS;
            extract(driverName, WIN_32_SYS);
        } else {
            driverName = WIN_IO_HOME + File.separator + WIN_64_SYS;
            extract(driverName, WIN_64_SYS);
        }
        extract(WIN_IO_HOME + File.separator + WIN_IO_INSTALLER, WIN_IO_INSTALLER);
        if (!WIN_IO.InitializeWinIo(new WString(driverName))) {
            throw new IllegalStateException("Cannot Initialize the WinIO");
        }
    }

    private static void extract(final String fileName, final String name) {
        try(InputStream inputStream = VirtualKeyBoard.class.getResourceAsStream("/" + name)) {
            Files.copy(inputStream, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待键盘缓冲区为空
     */
    private static void KBCWait4IBE() {
        int val;
        do {
            Pointer p = new Memory(8);
            if (!WIN_IO.GetPortVal(WinIo.CONTROL_PORT, p, 1)) {
                throw new RuntimeException("Cannot get the Port");
            }
            val = p.getInt(0);
        } while ((0x2 & val) > 0);
    }

    private static void down(int key) throws Exception {
        KBCWait4IBE();
        WIN_IO.SetPortVal(WinIo.CONTROL_PORT, 0xd2, 1);
        KBCWait4IBE();
        WIN_IO.SetPortVal(WinIo.DATA_PORT, key, 1);
    }

    private static void up(int key) throws Exception {
        KBCWait4IBE();
        WIN_IO.SetPortVal(WinIo.CONTROL_PORT, 0xd2, 1);
        KBCWait4IBE();
        WIN_IO.SetPortVal(WinIo.DATA_PORT, (key | 0x80), 1);
    }

    public static void press(String[] words, long firstSleepTime, long sleepTime) throws Exception{
        if (null == words || words.length == 0) {
            throw new IllegalArgumentException("words Is NULL Or Empty");
        }
        int minSleepTime = 50;
        if (sleepTime < minSleepTime) {
            throw new IllegalArgumentException("SleepTime Less Than 50 ms");
        }
        if (firstSleepTime > 0) {
            Thread.sleep(firstSleepTime);
        }
        for (String word : words) {
            Integer vk = VirtualKeyMapping.VK_MAP.get(word);
            if (null == vk) {
                vk = VirtualKeyMapping.NEED_SHIFT_VK.get(word);
            }
            if (null == vk) {
                throw new RuntimeException(word + " Not Support");
            }
            boolean needShift = word.length() == 1 && null != VirtualKeyMapping.NEED_SHIFT_VK.get(word);
            if (needShift) {
                down(VirtualKeyMapping.VK_MAP.get("LShift"));
            }
            down(vk);
            Thread.sleep(sleepTime);
            up(vk);
            if (needShift) {
                up(VirtualKeyMapping.VK_MAP.get("LShift"));
            }
        }
    }

}
