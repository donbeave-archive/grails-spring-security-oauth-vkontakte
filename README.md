grails-spring-security-oauth-vkontakte [![Build Status](https://api.travis-ci.org/donbeave/grails-spring-security-oauth-vkontakte.png?branch=master)](https://travis-ci.org/donbeave/grails-spring-security-oauth-vkontakte)
====================================

VK extension for [Grails Spring Security OAuth][spring-security-oauth-plugin] plugin

Installation
------------

Add the following plugin definition to your BuildConfig:
```groovy
// ...
plugins {
  // ...
  compile ':spring-security-oauth:2.0.2'
  compile ':spring-security-oauth-vkontakte:0.1'
  // ...
}
```

Usage
-----

Add to your Config:
```groovy
oauth {
  // ...
  providers {
    // ...
    vkontakte {
      api = org.scribe.builder.api.VkontakteApi
      key = 'oauth_vkontakte_key'
      secret = 'oauth_vkontakte_secret'
      successUri = '/oauth/vkontakte/success'
      failureUri = '/oauth/vkontakte/error'
      callback = "${baseURL}/oauth/vkontakte/callback"
    }
    // ...
  }
}
```

In your view you can use the taglib exposed from this plugin and from OAuth plugin to create links and to know if the user is authenticated with a given provider:
```xml
<oauth:connect provider="vkontakte" id="vkontakte-connect-link">VK</oauth:connect>

Logged with vkontakte?
<s2o:ifLoggedInWith provider="vkontakte">yes</s2o:ifLoggedInWith>
<s2o:ifNotLoggedInWith provider="vkontakte">no</s2o:ifNotLoggedInWith>
```

Copyright and license
---------------------

Copyright 2012-2014 Alexey Zhokhov under the [Apache License, Version 2.0](LICENSE). Supported by [Polusharie][polusharie].

[polusharie]: http://www.polusharie.com
[spring-security-oauth-plugin]: https://github.com/enr/grails-spring-security-oauth
