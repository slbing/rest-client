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
package org.wisdom.tool.model;

/** 
* @ClassName: ErrCode restclient/rest-client
* @Description: HTTP test error code 
* @Author: Dom Wang
* @Email: witpool@outlook.com 
* @Date: 2017-07-18 PM 3:30:01 
* @Version: 1.0 
*/
public enum ErrCode
{
    SUCCESS(10000),

    NO_CASE(10001),

    BAD_CASE(10002),

    INCONSISTENT_STATUS(10003),

    INCONSISTENT_BODY(10004),

    HTTP_REQUEST_FAILED(10005),

    BAD_JSON(10006);

    private int code;

    private ErrCode(int c)
    {
        this.code = c;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

}
