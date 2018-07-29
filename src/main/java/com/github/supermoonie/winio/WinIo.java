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
 * Provides access to the WinIo64.dll or WinIo32.dll library.
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
	 * This function initializes the WinIo library.
	 * The InitializeWinIo function must be called before using any other function in the library.
	 * Under Windows NT/2000/XP, calling InitializeWinIo grants the application full access to the I/O address space.
	 * Following a call to this function, an application is free to use the _inp/_outp functions provided by the C run-time library to access I/O ports on the system.
	 *
	 * @param path		The absolute path of WinIo64.sys or WinIo32.sys
	 * @return		If the function succeeds, the return value is true. Otherwise, the function returns false.
	 */
	boolean InitializeWinIo(WString path);

	/**
	 * This function performs cleanup of the WinIo library.
	 * The ShutdownWinIo function must be called before terminating the application or in case the WinIo library is no longer required.
	 * This function shuts down the WinIo library and frees the resources which were allocated by a call to the InitializeWinIo function.
	 */
	void ShutdownWinIo();

	/**
	 *
	 * This function reads a BYTE/WORD/DWORD value from an I/O port.
	 * The GetPortVal function reads a byte, a word or a double word from the specified I/O port.
	 * Note: Under Windows 98/ME, an application must use the GetPortVal function to read values from an I/O port.
	 * Under Windows NT/2000/XP, it is possible to use the _inp/_inpw/_inpd functions instead of using GetPortVal,
	 * provided that the InitializeWinIo function has been called beforehand.
	 *
	 * @param portAddr		[in] I/O port address
	 * @param pPortVal		[out] Pointer to a DWORD variable that receives the value obtained from the port.
	 * @param size		[in] Number of bytes to read.
	 *                  Can be 1 (BYTE), 2 (WORD) or 4 (DWORD).
	 * @return		If the function succeeds, the return value is true. Otherwise, the function returns false.
	 */
	boolean GetPortVal(int portAddr, Pointer pPortVal, int size);

	/**
	 * This function writes a BYTE/WORD/DWORD value to an I/O port.
	 * The SetPortVal function writes a byte, a word or a double word to the specified I/O port.
	 * Note: Under Windows 98/ME, an application must use the SetPortVal function to write values to an I/O port.
	 * Under Windows NT/2000/XP, it is possible to use the _outp/_outpw/_outpd functions instead of using SetPortVal,
	 * provided that the InitializeWinIo function has been called beforehand.
	 *
	 * @param portAddr		[in] I/O port address
	 * @param portVal		[in] Value to be written to the port
	 * @param size			[in] Number of bytes to write.
	 *                      Can be 1 (BYTE), 2 (WORD) or 4 (DWORD).
	 * @return		If the function succeeds, the return value is true. Otherwise, the function returns false.
	 */
	boolean SetPortVal(int portAddr, int portVal, int size);
	
}
