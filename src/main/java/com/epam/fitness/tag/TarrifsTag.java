package com.epam.fitness.tag;

import com.epam.fitness.utils.MembershipPrices;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Define to provide tariffs by jsp tag
 */
public class TarrifsTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        Map<Integer,BigDecimal> tariffs = MembershipPrices.getInstance().getAllCosts();
        JspWriter out = pageContext.getOut();
        try {
        out.write("<option value=\"Choose tariff\"></option>");
            for (Map.Entry<Integer, BigDecimal> tariff : tariffs.entrySet()) {
                out.write("<option value=\"" + tariff.getValue() + " \">" + tariff.getKey() + " days</option>");
            }
        }catch (IOException exception){
            throw new JspException(exception.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag(){
        return EVAL_PAGE;
    }
}
