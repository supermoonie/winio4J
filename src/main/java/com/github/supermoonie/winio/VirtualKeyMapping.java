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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Virtual Key Mapping
 * https://www.win.tue.nl/~aeb/linux/kbd/scancodes-1.html
 *
 * @author supermoonie
 * @date 2018/7/27
 */
public class VirtualKeyMapping {

    /**
     * Base virtual keys
     */
    static final Map<String, Integer> VK_MAP = new HashMap<>();

    /**
     * The virtual keys need shift
     */
    static final Map<String, Integer> NEED_SHIFT_VK = new HashMap<>();

    static {
        VK_MAP.put("Esc", 0x01);
        VK_MAP.put("1", 0x02);
        VK_MAP.put("2", 0x03);
        VK_MAP.put("3", 0x04);
        VK_MAP.put("4", 0x05);
        VK_MAP.put("5", 0x06);
        VK_MAP.put("6", 0x07);
        VK_MAP.put("7", 0x08);
        VK_MAP.put("8", 0x09);
        VK_MAP.put("9", 0x0a);
        VK_MAP.put("0", 0x0b);
        VK_MAP.put("-", 0x0c);
        VK_MAP.put("=", 0x0d);
        VK_MAP.put("Backspace", 0x0e);
        VK_MAP.put("Tab", 0x0f);
        VK_MAP.put("q", 0x10);
        VK_MAP.put("w", 0x11);
        VK_MAP.put("e", 0x12);
        VK_MAP.put("r", 0x13);
        VK_MAP.put("t", 0x14);
        VK_MAP.put("y", 0x15);
        VK_MAP.put("u", 0x16);
        VK_MAP.put("i", 0x17);
        VK_MAP.put("o", 0x18);
        VK_MAP.put("p", 0x19);
        VK_MAP.put("[", 0x1a);
        VK_MAP.put("]", 0x1b);
        VK_MAP.put("Enter", 0x1c);
        VK_MAP.put("LCtrl", 0x1d);
        VK_MAP.put("a", 0x1e);
        VK_MAP.put("s", 0x1f);
        VK_MAP.put("d", 0x20);
        VK_MAP.put("f", 0x21);
        VK_MAP.put("g", 0x22);
        VK_MAP.put("h", 0x23);
        VK_MAP.put("j", 0x24);
        VK_MAP.put("k", 0x25);
        VK_MAP.put("l", 0x26);
        VK_MAP.put(";", 0x27);
        VK_MAP.put("'", 0x28);
        VK_MAP.put("`", 0x29);
        VK_MAP.put("LShift", 0x2a);
        VK_MAP.put("\\", 0x2b);
        VK_MAP.put("z", 0x2c);
        VK_MAP.put("x", 0x2d);
        VK_MAP.put("c", 0x2e);
        VK_MAP.put("v", 0x2f);
        VK_MAP.put("b", 0x30);
        VK_MAP.put("n", 0x31);
        VK_MAP.put("m", 0x32);
        VK_MAP.put(",", 0x33);
        VK_MAP.put(".", 0x34);
        VK_MAP.put("/", 0x35);
        VK_MAP.put("RShift", 0x36);
        VK_MAP.put("LAlt", 0x38);
        VK_MAP.put("Space", 0x39);
        VK_MAP.put("CapsLock", 0x3a);
        VK_MAP.put("F1", 0x3b);
        VK_MAP.put("F2", 0x3c);
        VK_MAP.put("F3", 0x3d);
        VK_MAP.put("F4", 0x3e);
        VK_MAP.put("F5", 0x3f);
        VK_MAP.put("F6", 0x40);
        VK_MAP.put("F7", 0x41);
        VK_MAP.put("F8", 0x42);
        VK_MAP.put("F9", 0x43);
        VK_MAP.put("F10", 0x44);
        VK_MAP.put("NumLock", 0x45);
        VK_MAP.put("ScrollLock", 0x46);
        VK_MAP.put("F11", 0x57);
        VK_MAP.put("F12", 0x58);
    }

    static {
        NEED_SHIFT_VK.put("!", 0x02);
        NEED_SHIFT_VK.put("@", 0x03);
        NEED_SHIFT_VK.put("#", 0x04);
        NEED_SHIFT_VK.put("$", 0x05);
        NEED_SHIFT_VK.put("%", 0x06);
        NEED_SHIFT_VK.put("^", 0x07);
        NEED_SHIFT_VK.put("&", 0x08);
        NEED_SHIFT_VK.put("*", 0x09);
        NEED_SHIFT_VK.put("(", 0x0a);
        NEED_SHIFT_VK.put(")", 0x0b);
        NEED_SHIFT_VK.put("_", 0x0c);
        NEED_SHIFT_VK.put("+", 0x0d);
        NEED_SHIFT_VK.put("{", 0x1a);
        NEED_SHIFT_VK.put("}", 0x1b);
        NEED_SHIFT_VK.put(":", 0x27);
        NEED_SHIFT_VK.put("\"", 0x28);
        NEED_SHIFT_VK.put("~", 0x29);
        NEED_SHIFT_VK.put("|", 0x2b);
        NEED_SHIFT_VK.put("<", 0x33);
        NEED_SHIFT_VK.put(">", 0x34);
        NEED_SHIFT_VK.put("?", 0x35);
        NEED_SHIFT_VK.put("Q", 0x10);
        NEED_SHIFT_VK.put("W", 0x11);
        NEED_SHIFT_VK.put("E", 0x12);
        NEED_SHIFT_VK.put("R", 0x13);
        NEED_SHIFT_VK.put("T", 0x14);
        NEED_SHIFT_VK.put("Y", 0x15);
        NEED_SHIFT_VK.put("U", 0x16);
        NEED_SHIFT_VK.put("I", 0x17);
        NEED_SHIFT_VK.put("O", 0x18);
        NEED_SHIFT_VK.put("P", 0x19);
        NEED_SHIFT_VK.put("A", 0x1e);
        NEED_SHIFT_VK.put("S", 0x1f);
        NEED_SHIFT_VK.put("D", 0x20);
        NEED_SHIFT_VK.put("F", 0x21);
        NEED_SHIFT_VK.put("G", 0x22);
        NEED_SHIFT_VK.put("H", 0x23);
        NEED_SHIFT_VK.put("J", 0x24);
        NEED_SHIFT_VK.put("K", 0x25);
        NEED_SHIFT_VK.put("L", 0x26);
        NEED_SHIFT_VK.put("Z", 0x2c);
        NEED_SHIFT_VK.put("X", 0x2d);
        NEED_SHIFT_VK.put("C", 0x2e);
        NEED_SHIFT_VK.put("V", 0x2f);
        NEED_SHIFT_VK.put("B", 0x30);
        NEED_SHIFT_VK.put("N", 0x31);
        NEED_SHIFT_VK.put("M", 0x32);
    }

    /**
     * Get all support keys
     *
     * @return  Return all support keys
     */
    public static String[] getSupportKeys() {
        String[] vkArray = VK_MAP.keySet().toArray(new String[0]);
        String[] needShiftVKArray = NEED_SHIFT_VK.keySet().toArray(new String[0]);
        String[] supportKeys = new String[vkArray.length + needShiftVKArray.length];
        System.arraycopy(vkArray, 0, supportKeys, 0, vkArray.length);
        System.arraycopy(needShiftVKArray, 0, supportKeys, vkArray.length, needShiftVKArray.length);
        return supportKeys;
    }

}
