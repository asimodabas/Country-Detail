# Country-Detail

* The flags of the countries are listed in this program.
* When the layouts on the listed flags are clicked, information such as the name, capital, region, currency, flag, language of that flag is displayed.
* every flag data is integrated into the application with API.
* The architecture used in the project is mvvm architecture.
* Data is pulled from the internet and retrofit is used for this process.
* Texts from the Internet are saved in sqlite.
* Room library is used for sqlite registration.
* If backpress is done after entering the detail table, the link in the room library is displayed and no data is retrieved from the internet again.
* If the page is being refreshed or renewed, it is taken from the internet again and saved to sqlite together with the room.
* Used glide library when drawing

Libraries Used
--------------
* [Lifecycles][1] - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.
* [Navigation][2] - Navigating to a destination is done using a NavController, an object that manages app navigation within a NavHost. Each NavHost has its own corresponding NavController. NavController provides a few different ways to navigate to a destination, which are further described in the sections below.
* [Retrofit][3] - Retrofit is a network library used among Android Developers. Easy access to REST APIs, testable and easy to use were factors that made Retrofit so popular.
* [RxJava][4] - RxJava is a library for composing asynchronous and event-based code by using observable sequences and functional style operators, allowing for parameterized execution via schedulers.
* [Room Database][5] - Apps that handle non-trivial amounts of structured data can benefit greatly from persisting that data locally. The most common use case is to cache relevant pieces of data so that when the device cannot access the network, the user can still browse that content while they are offline.
* [Glide][6] - Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
* [Data Binding][7] - The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.

App Images
--------------
<p align="center">
  <img src="https://user-images.githubusercontent.com/71982171/208989927-612c223a-e1f0-4000-9abc-b9edb274db2f.gif" alt="GIF" />
</p>

MIT License

Copyright (c) 2023 Asım Odabaş

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

[1]: https://developer.android.com/jetpack/androidx/releases/lifecycle
[2]: https://developer.android.com/guide/navigation/navigation-navigate
[3]: https://square.github.io/retrofit/
[4]: https://github.com/ReactiveX/RxJava
[5]: https://developer.android.com/training/data-storage/room
[6]: https://github.com/bumptech/glide
[7]: https://developer.android.com/topic/libraries/data-binding
