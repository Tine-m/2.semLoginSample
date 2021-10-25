# 2.semLoginSample

The web app illustrates the use of session object (WebRequest.SCOPE_SESSION) to hold user object after login/user registration. The Http protocol is by nature stateless, meaning that the web server does not keep session state from previous requests by the client (browser). This has a number of advantages:
<p>
  Visibility is improved because a monitoring system does not have to look beyond a single request in order to determine its full nature. Reliability is improved because it eases the task of recovering from partial failures. Scalability is improved because not having to store session state between requests allows the server to quickly free resources and further simplifies implementation.

The disadvantage of stateless protocols is that they may decrease network performance by increasing the repetitive data sent in a series of requests, since that data cannot be left on the server and reused.
  </p> 
  [wiki](https://en.wikipedia.org/wiki/Stateless_protocol)

<p>
Session provides a way to identify a user across more than one page request and to store information about <i>that</i> user. The session object is automatically created by Spring Framework, but you must provide it with whatever data the app needs for a speficic client. For instance user identification or items in a shopping cart in web shop.
<p>

![](img/ServiceLayerSketch.gif)

bla
![](img/all_more.png)
