package com.pxa.sample.client.kit;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2023-04-19 23:52
 */
public class UIKit {

    public static String createTopBarTitle(String title, String fontAwesomeIcon, String color) {
        String rawTitle = "<nobr><span style='display:inline-block;line-height:22px;vertical-align:text-top;font-size:14px;color:{0}'>&nbsp;" +
                "<i class='fa {1}'></i>&nbsp;{2}</span></nobr>";
        return StringKit.format(rawTitle, color, fontAwesomeIcon, title);
    }

}
