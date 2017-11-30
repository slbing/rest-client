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
* @ClassName: Results 
* @Description: HTTP test results 
* @Author: Dom Wang
* @Email: witpool@outlook.com 
* @Date: 2016-12-18 PM 3:30:01 
* @Version: 1.0 
*/
public enum Results
{
    FAILURE("failure"), PASS("pass"), ERROR("error");

    private String result;

    private Results(String rs)
    {
        this.result = rs;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

}
