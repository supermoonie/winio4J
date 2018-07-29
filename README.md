# WinIo4J

[![Gitter](https://badges.gitter.im/supermoonie/winio4J.svg)](https://gitter.im/supermoonie/winio4J?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

A Java JNA wrapper for WinIo.

WinIo4J is released and distributed under the [Apache License, v2.0](http://www.apache.org/licenses/LICENSE-2.0).

# Features

The library provides access to "WinIo64.dll" or "WinIo32.dll" and support for:

- Auto distingush 64 Bit or 32 Bit
- Case sensitive
- Can run as No-Administrator (after execute WinIoInstall.exe)

# Notice

1. If your Windows is 64 Bit , you should run this command as Administrator in cmd:

   > bcdedit /set testsigning on 

   Then reboot your computer.

2. Before use this library , "WinIoInstall.exe" must by executed. It will install WinIo driver on your system.

3. Make sure the WinIo driver has installed on your system:

   > sc query winio

   Execute the command in a cmd, if you can see the keyword "RUNNING", that's OK!

# Finally

If you want to remove the WinIo driver , you can do like this:

1. Open a cmd by Administrator

2. Type the following command:

   > sc stop winio
   >
   > sc delete winio

# Contributors

A big thanks to GitHub and MySelf ! (hahaha...)