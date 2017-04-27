package cn.fintecher.print.service.summons.service.impl;

import cn.fintecher.print.service.summons.service.SummonsService;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Map;

/**
 * @Author : sunyanping
 * @Description :
 * @Date : 2017/4/27.
 */
public class SummonsServiceImpl implements SummonsService {

    @Autowired
    private Configuration configuration;

    @Override
    public void ProdPdf(Map<String, Object> model) throws IOException, TemplateException {
        // 获取到对应的模板
        Template template = configuration.getTemplate("welcome.ftl");
        // String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        // 指定生成的html文件位置
        File file = new File("d:/welcome.html");
        if (!file.exists()) {
            file.createNewFile();
        }
        //FileUtils.writeStringToFile(file, content);
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "utf-8"));
        template.process(model, out);
        out.flush();

        String url = new File("d:/welcome.html").toURI().toURL().toString();
        // 指定生成的pdf文件
        String outputFile = "d:/welcome.pdf";
        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        // 解决中文问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        try {
            fontResolver.addFont("C:/windows/Fonts/simsun.ttc",
                    BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        renderer.layout();
        try {
            renderer.createPDF(os);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println("转换成功！");
        os.close();
    }
}
