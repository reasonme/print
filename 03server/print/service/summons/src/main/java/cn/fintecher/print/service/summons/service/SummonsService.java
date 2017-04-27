package cn.fintecher.print.service.summons.service;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * @Author : sunyanping
 * @Description :
 * @Date : 2017/4/27.
 */
public interface SummonsService {

    void ProdPdf(Map<String, Object> model) throws IOException, TemplateException;

}
