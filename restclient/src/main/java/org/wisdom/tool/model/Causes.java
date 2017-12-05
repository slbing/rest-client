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

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 
* @ClassName: Causes for restclient/rest-client
* @Description: Test causes 
* @Author: Dom Wang
* @Email: witpool@outlook.com 
* @Date: 2016-12-25 PM 8:21:08 
* @Version: 1.0 
*/
public class Causes implements Serializable
{
    private static final long serialVersionUID = 5746546932645175308L;

    @JsonProperty("messages")
    private Map<Integer, Cause> causes = null;

    private Integer total = 0;

    public Causes()
    {
        if (null != causes)
        {
            this.total = this.causes.size();
        }
    }

    public Causes(Map<Integer, Cause> causes)
    {
        this.causes = causes;
        if (null != causes)
        {
            this.total = this.causes.size();
        }
    }

    public Map<Integer, Cause> getCauses()
    {
        return causes;
    }

    public void setCauses(Map<Integer, Cause> causes)
    {
        this.causes = causes;
        if (null != causes)
        {
            this.total = this.causes.size();
        }
    }

    public Integer getTotal()
    {
        return total;
    }

    public void setTotal(Integer total)
    {
        this.total = total;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Causes [causes=");
        builder.append(causes);
        builder.append(", total=");
        builder.append(total);
        builder.append("]");
        return builder.toString();
    }

}
