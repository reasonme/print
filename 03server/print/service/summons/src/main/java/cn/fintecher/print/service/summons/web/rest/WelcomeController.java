package cn.fintecher.print.service.summons.web.rest;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Date;
import java.util.Map;

/**
 * @Author : sunyanping
 * @Description :
 * @Date : 2017/4/27.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/WelcomeController")
public class WelcomeController {

    @Autowired
    private Configuration configuration;

    @RequestMapping(value = "/template/freemarker/welcome", method = RequestMethod.GET)
    public void welcome2(Map model) throws Exception {
        model.put("time", new Date());
        model.put("message", "孙艳平");

        Template template = configuration.getTemplate("welcome.ftl");
        //String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

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
        //return "welcome";
    }
}
