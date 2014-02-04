/*
 * Copyright 2012 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugin.springsecurity.oauth

import org.scribe.model.Token

/**
 * OAuth authentication token for VK (Vkontakte) users. It's a standard {@link OAuthToken}
 * that returns the Weibo User ID as the principal.
 *
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 */
class VkontakteOAuthToken extends OAuthToken {

  public static final String PROVIDER_NAME = 'vkontakte'

  String uid
  
  String firstName
  
  String lastName
  
  String nickname
  
  String cityId
  
  String cityName
  
  VkontakteOAuthToken(Token scribeToken, uid) {
    super(scribeToken)
    this.uid = uid
    this.principal = uid
  }
  
  VkontakteOAuthToken(Token scribeToken, uid, String firstName, String lastName) {
	super(scribeToken)
	this.uid = uid
	this.principal = uid
	this.firstName = firstName
	this.lastName = lastName
  }

  String getSocialId() {
    return uid
  }

  String getScreenName() {
    return uid
  }

  String getProviderName() {
    return PROVIDER_NAME
  }

}