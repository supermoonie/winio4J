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

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.win32.W32APIOptions;


/**
 *
 * 提供对 WinIo32.dll 或 WinIo64.dll 的访问
 *
 * @author supermoonie
 * @date 2018/7/27
 */
public interface WinIo extends Library {

	String ARCH = System.getProperty("os.arch");
	String WIN_IO_LIB_NAME = "x86".equals(ARCH) ? "WinIo32" : "WinIo64";
	WinIo INSTANCE = (WinIo) Native.loadLibrary(WIN_IO_LIB_NAME, WinIo.class, W32APIOptions.DEFAULT_OPTIONS);

	int CONTROL_PORT = 0x64;
	int DATA_PORT = 0x60;

	/**
	 * 初始化WinIo：
	 * 		1. 安装 winIo 驱动
	 * 		2. 创建 winIo 服务并随系统一起启动
	 * @param path		winIo 驱动路径
	 * @return		初始化成功返回 true 否则返回 false
	 */
	boolean InitializeWinIo(WString path);

	/**
	 * 关闭 winIo：
	 * 		1. 关闭 winIo 服务
	 * 		2. 移除 winIo 驱动
	 */
	void ShutdownWinIo();

	/**
	 *
	 * 将一个字节/字/双字的数据写入输入或输出接口
	 *
	 * @param portAddr		输入输出口地址
	 * @param pPortVal		要写入口的数据
	 * @param size			要写的数据个数，可以是 1 (BYTE), 2 (WORD) or 4 (DWORD)
	 * @return		调用成功返回 true，失败返回 false
	 */
	boolean GetPortVal(int portAddr, Pointer pPortVal, int size);

	/**
	 * 从一个输入或输出端口读取一个字节/字/双字数据
	 *
	 * @param portAddr		输入输出端口地址
	 * @param portVal		指向双字变量的指针，接收从端口得到的数据
	 * @param size			需要读的字节数，可以是1 (BYTE), 2 (WORD) or 4 (DWORD)
	 * @return		调用成功返回 true，失败返回 false
	 */
	boolean SetPortVal(int portAddr, int portVal, int size);
	
}
