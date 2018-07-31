# WinIo4J

[![Gitter](https://badges.gitter.im/supermoonie/winio4J.svg)](https://gitter.im/supermoonie/winio4J?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

A Java JNA wrapper for WinIo.

WinIo4J is released and distributed under the [Apache License, v2.0](http://www.apache.org/licenses/LICENSE-2.0).

# Features

The library provides access to "WinIo64.dll" or "WinIo32.dll" and support for:

- Auto distingush 64 Bit or 32 Bit
- Case sensitive
- Can configure the WinIo64.sys or WinIo32.sys path

# Notice

1. If desktops , You need a keyboard which interface is PS/2.

2. If your Windows is 64 Bit , This command should be run as Administrator in cmd:

   > bcdedit /set testsigning on 

   Then reboot your computer.

3. Run the application as Administrator at first time.

   Or 

   Provided that the [WinIoInstall.exe](https://github.com/supermoonie/winio4J/tree/master/src/main/resources) has been called beforehand.

   It will install WinIo driver on your system.

4. To make sure the WinIo driver has been installed on your system:

   > sc query winio

   Execute the command in a cmd, If you can see the keyword "RUNNING", That's OK!

# Finally

If you want to remove the WinIo driver , You can do it like this:

1. Run a cmd as Administrator.

2. Type the following command:

   > sc stop winio
   >
   > sc delete winio

# Contributors

A big thanks to GitHub and MySelf ! :laughing: