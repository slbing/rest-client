/* 
 * Copyright 2016-2017 WisdomTool.org restclient/rest-client. All Rights Reserved.
 * 
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
   
 *  http://www.wisdomtool.org/restclient/rest-client/licenses
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.wisdom.tool.except;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.wisdom.tool.model.Cause;
import org.wisdom.tool.model.Results;

/** 
* @ClassName: RESTException for restclient/rest-client
* @Description: REST exception
* @Author: Dom Wang
* @Email: witpool@outlook.com 
* @Date: 2017-07-25 PM 8:40:33 
* @Version: 1.0 
*/
public class RESTException extends Exception
{
    private static Logger log = LogManager.getLogger(RESTException.class);

    private static final long serialVersionUID = -8596508991250642705L;

    private String status;

    public RESTException()
    {
    }

    public RESTException(String message)
    {
        super(message);
    }

    public RESTException(Cause c)
    {
        super(c.toString());
        this.setStatus(Results.ERROR.getResult());
        log.error(c.toString());
    }

    public RESTException(Cause c, Results r)
    {
        super(c.toString());
        this.setStatus(r.getResult());
        log.error(c.toString());
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
