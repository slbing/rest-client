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
package org.wisdom.tool;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.wisdom.tool.constant.RESTConst;
import org.wisdom.tool.gui.RESTView;
import org.wisdom.tool.gui.menu.MenuBarView;
import org.wisdom.tool.gui.util.UIUtil;
import org.wisdom.tool.model.HttpHists;
import org.wisdom.tool.util.RESTUtil;

/** 
 * @ClassName: RESTMain 
 * @Description: Rest Main
 * @Author: Dom Wang
 * @Email: witpool@outlook.com 
 * @Date: Jan 20, 2017 12:30:29 PM 
 * @Version: 1.0 
 */
public class RESTMain
{
    private static Logger log = LogManager.getLogger(RESTMain.class);

    private static WindowAdapter wa = new WindowAdapter()
    {
        public void windowClosing(WindowEvent e)
        {
            UIUtil.saveFile();
        }
    };

    /**
    * 
    * @Title: load 
    * @Description: Load configurations 
    * @param
    * @return void 
    * @throws
     */
    private static void load()
    {
        try
        {
            File fhist = new File(RESTConst.HTTP_HIST_JSON);
            if (!fhist.exists())
            {
                return;
            }

            HttpHists hists = RESTUtil.toOject(fhist, HttpHists.class);
            UIUtil.setRESTView(hists);
        }
        catch(Throwable e)
        {
            log.error("Failed to load file.", e);
        }
    }
    
    /**
    * 
    * @Title: init 
    * @Description: Component Initialization 
    * @param
    * @return void 
    * @throws
     */
    private static void init()
    {
        MenuBarView mbv = new MenuBarView();
        JFrame frame = new JFrame(RESTConst.REST_CLIENT_VERSION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(mbv.getJMenuBar());
        frame.getContentPane().add(RESTView.getView());
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(wa);
        frame.setIconImage(UIUtil.getImage(RESTConst.LOGO));
        frame.setMinimumSize(new Dimension(720, 600));
        UIUtil.setLocation(frame);
    }

    /**
    * 
    * @Title: openView 
    * @Description: Open REST view 
    * @param
    * @return void 
    * @throws
     */
    public static void openView()
    {
        load();
        init();
    }

    /**
    * 
    * @Title: closeView 
    * @Description: Close REST view  
    * @param  
    * @return void
    * @throws
     */
    public static void closeView()
    {
        UIUtil.saveFile();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                RESTMain.openView();
            }
        });
    }

}
