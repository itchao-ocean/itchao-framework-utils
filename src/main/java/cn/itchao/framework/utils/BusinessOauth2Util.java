/**
 * Copyright (c) 2011-2030, author jinchao (370696614@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package cn.itchao.framework.utils;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author jinchao
 */
public class BusinessOauth2Util {

    public UserJwt getUserJwtFromHeader(HttpServletRequest request){
        Map<String, String> jwtClaims = Oauth2Util.getJwtClaimsFromHeader(request);
        if(jwtClaims == null || StringUtils.isEmpty(jwtClaims.get("id"))){
            return null;
        }
        UserJwt userJwt = new UserJwt();
        userJwt.setId(jwtClaims.get("id"));
        userJwt.setName(jwtClaims.get("name"));
        userJwt.setCompanyId(jwtClaims.get("companyId"));
        userJwt.setUtype(jwtClaims.get("utype"));
        userJwt.setUserpic(jwtClaims.get("userpic"));
        return userJwt;
    }

    @Data
    public class UserJwt{
        private String id;
        private String name;
        private String userpic;
        private String utype;
        private String companyId;
    }

}
