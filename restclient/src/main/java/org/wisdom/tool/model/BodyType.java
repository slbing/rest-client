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
* @ClassName: BodyType 
* @Description: Body type 
* @Author: Dom Wang
* @Email: witpool@outlook.com 
* @Date: 2017-07-22 PM 10:42:57 
* @Version: 1.0 
*/
public enum BodyType
{
    STRING(0, "String"), FILE(1, "File");

    private int tid;

    private String type;

    private BodyType(int tid, String type)
    {
        this.tid = tid;
        this.type = type;
    }

    /**
     * @return tid
     */
    public int getTid()
    {
        return tid;
    }

    /**
     * @param tid
     *            the tid to set
     */
    public void setTid(int tid)
    {
        this.tid = tid;
    }

    /**
     * @return type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }

}
