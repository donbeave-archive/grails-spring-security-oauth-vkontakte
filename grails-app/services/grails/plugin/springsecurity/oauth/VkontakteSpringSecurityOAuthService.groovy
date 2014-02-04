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

import grails.converters.JSON
import org.apache.commons.logging.LogFactory

/**
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 */
class VkontakteSpringSecurityOAuthService {

  def oauthService

  private static final log = LogFactory.getLog(VkontakteSpringSecurityOAuthService.class)

  /**
   * This implementation make request for getProfiles method.
   * @see http://vk.com/pages.php?o=-1&p=getProfiles
   * 
   * @param accessToken
   * @return
   */
  def createAuthToken(accessToken) {
    def response = oauthService.getVkontakteResource(accessToken, 'https://api.vk.com/method/getProfiles?fields=city,nickname,screen_name,sex')
    def user = JSON.parse(response.body)
    def u = user.response.get(0)
    log.trace(u as String)

    def cityId = u.city
    
    response = oauthService.getVkontakteResource(accessToken, 'https://api.vk.com/method/places.getCityById?cids=' + cityId)
    def city = JSON.parse(response.body)
    log.trace(city as String)
    
    def cityName = city.response.get(0).name
    
    def VkontakteOAuthToken token = new VkontakteOAuthToken(accessToken, u.uid, u.first_name, u.last_name)
    token.cityName = cityName
    token.cityId = cityId
    token.nickname = u.nickname
    
    return token
  }

}
