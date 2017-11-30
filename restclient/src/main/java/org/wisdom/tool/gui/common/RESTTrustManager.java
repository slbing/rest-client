/* 
 * Copyright 2016-2017 WisdomTool.org. All Rights Reserved.
 * 
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
   
 *  http://www.wisdomtool.org/licenses
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.wisdom.tool.gui.common;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/** 
* @ClassName: RESTTrustManager 
* @Description: REST trust manager 
* @Author: Dom Wang
* @Email: witpool@outlook.com 
* @Date: Jul 26, 2017 5:32:58 PM 
* @Version: 1.0 
*/
public class RESTTrustManager implements TrustManager, X509TrustManager
{
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
    {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
    {
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}
