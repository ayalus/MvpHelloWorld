# MvpHelloWorld

Ive been searching for a simple MVP example and found NONE. Wierd right? Ive decided to share the most basic example.

In this MVP Hello World app, you can see an example of the most basic posible form of Model View Presenter Design Patteren, as i understand it. It could be used as a template and expanded as needed.


Branches: (for beginers, start with branch "mvp-simple-hello-world")

1. Mvp-simple-hello-world - clean Hello World MVP example: has a toast and a background color change function.

2. Master - added random functionality to preform things in the MVP design (still in progress).
  - Toast input from edit text
  - Change background colors
  - Parse Json string
  - API Call to AccuWeather and displays info on screen.
  
  *for the Accuweather API call you need to register to https://developer.accuweather.com/ -->"My apps" tab --> make a new app.   then add the API_KEY to the "Constants" class.


Run instructions:
- clone to requested folder.
- in Android Studio: File >> New >> import project..

then git checkout into mvp-simple-hello-world with command:
git checkout mvp-simple-hello-world



