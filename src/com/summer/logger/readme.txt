Copyright 2016 Orhan Obut

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
-------------------------------------------------------------------------------
https://github.com/orhanobut/logger
-------------------------------------------------------------------------------
Logger

Simple, pretty and powerful logger for android

Logger provides :

Thread information
Class information
Method information
Pretty-print for json content
Pretty-print for new line "\n"
Clean output
Jump to source
-----------------------------------------------------------------------------------

Change the settings with init. This should be called only once. Best place would be in application class. All of them are optional.

Logger
  .init(YOUR_TAG)                 // default PRETTYLOGGER or use just init()
  .methodCount(3)                 // default 2
  .hideThreadInfo()               // default shown
  .logLevel(LogLevel.NONE)        // default LogLevel.FULL
  .methodOffset(2)                // default 0
  .logTool(new AndroidLogTool()); // custom log tool, optional
}

-----------------------------------------------------------------------------------