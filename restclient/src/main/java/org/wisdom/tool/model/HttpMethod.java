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
package org.wisdom.tool.model;

/** 
* @ClassName: HttpMethod 
* @Description: HTTP method 
* @Author: Dom Wang
* @Email: witpool@outlook.com 
* @Date: 2017-07-22 PM 10:42:57 
* @Version: 1.0 
*/
public enum HttpMethod
{
    GET(0), POST(1), PUT(2), DELETE(3);
    
    private int mid;

    private HttpMethod(int mid)
    {
        this.mid = mid;
    }

    /** 
    * @return mid 
    */
    public int getMid()
    {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(int mid)
    {
        this.mid = mid;
    }
    
}
