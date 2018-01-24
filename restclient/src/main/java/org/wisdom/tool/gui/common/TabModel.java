/*
 * Copyright 2017-present, Yudong (Dom) Wang
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
package org.wisdom.tool.gui.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.swing.table.AbstractTableModel;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

/** 
* @ClassName: TabModel 
* @Description: REST table model 
* @Author: Yudong (Dom) Wang
* @Email: wisdomtool@outlook.com 
* @Date: 2017-07-22 PM 10:42:57 
* @Version: WisdomTool RESTClient V1.1 
*/
public class TabModel extends AbstractTableModel
{
    private static final long serialVersionUID = 69634209639612612L;

    private List<String> colNames = null;

    private Map<String, List<Object>> tabData = new LinkedHashMap<String, List<Object>>();

    public TabModel(final List<String> colNames)
    {
        if (colNames.size() < 1)
        {
            return;
        }
        this.colNames = colNames;
    }

    public String getColumnName(int cidx)
    {
        return colNames.get(cidx);
    }

    public int getRowCount()
    {
        return tabData.size();
    }

    public int getColumnCount()
    {
        if (null == colNames)
        {
            return 0;
        }
        return colNames.size();
    }

    public Object getValueAt(int row, int col)
    {
        List<Object> rowLst = this.getRow(row);
        if (CollectionUtils.isEmpty(rowLst))
        {
            return null;
        }
        if (col >= rowLst.size())
        {
            return null;
        }
        return rowLst.get(col);
    }

    public void setValueAt(Object value, int row, int col)
    {
        List<Object> rowLst = this.getRow(row);
        if (CollectionUtils.isEmpty(rowLst))
        {
            return;
        }
        rowLst.set(col, value);
        fireTableCellUpdated(row, col);
    }

    public boolean isCellEditable(int row, int col)
    {
        return true;
    }

    public Class<?> getColumnClass(int c)
    {
        Object val = this.getValueAt(0, c);
        if (null == val)
        {
            return String.class;
        }
        return val.getClass();
    }
    
    public String insertRow(Object... values)
    {
        List<Object> rowLst = new ArrayList<Object>();
        for (Object value : values)
        {
            rowLst.add(value);
        }

        String key = UUID.randomUUID().toString();
        tabData.put(key, rowLst);
        fireTableDataChanged();
        return key;
    }

    public List<Object> getRow(int row)
    {
        if (MapUtils.isEmpty(tabData))
        {
            return null;
        }

        Collection<List<Object>> values = tabData.values();
        @SuppressWarnings("unchecked")
        List<Object> rowLst = (List<Object>) CollectionUtils.get(values, row);
        return rowLst;
    }

    public List<Object> getRow(String key)
    {
        return tabData.get(key);
    }

    public Map<String, Object> getColumn(int col)
    {
        Map<String, Object> columns = new LinkedHashMap<String, Object>();
        int count = getColumnCount();
        if (col >= count)
        {
            return columns;
        }

        List<Object> valLst = null;
        Set<Entry<String, List<Object>>> es = tabData.entrySet();
        for (Entry<String, List<Object>> e : es)
        {
            valLst = e.getValue();
            if (CollectionUtils.isEmpty(valLst))
            {
                continue;
            }

            if (col >= valLst.size())
            {
                continue;
            }
            columns.put(e.getKey(), valLst.get(col));
        }
        return columns;
    }

    public String getRowKey(int row)
    {
        List<String> keyLst = new ArrayList<String>(tabData.keySet());
        return keyLst.get(row);
    }

    public void deleteRow(int... rows)
    {
        List<String> keyLst = new ArrayList<String>(tabData.keySet());
        for (int row : rows)
        {
            if (row < 0 || row >= keyLst.size())
            {
                continue;
            }
            tabData.remove(keyLst.get(row));
        }
        fireTableDataChanged();
    }

    public void clear()
    {
        if (MapUtils.isEmpty(tabData))
        {
            return;
        }
        tabData.clear();
        fireTableDataChanged();
    }

    public Collection<List<Object>> getValues()
    {
        return tabData.values();
    }
}
