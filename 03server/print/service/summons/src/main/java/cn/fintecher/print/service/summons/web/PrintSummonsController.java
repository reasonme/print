package cn.fintecher.print.service.summons.web;

import cn.fintecher.print.model.Result;
import cn.fintecher.print.service.summons.model.Summons;
import cn.fintecher.print.service.summons.service.PrintService;
import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : sunyanping
 * @Description :
 * @Date : 2017/4/27.
 */
@ApiModel("法院传票打印操作")
@RestController
@RequestMapping("/api/PrintSummonsController")
public class PrintSummonsController {

    @Autowired
    private Configuration configuration;
    @Autowired
    PrintService printService;

    @GetMapping(value = "/printSummons")
    @ApiOperation(value = "打印法院传单", notes = "打印法院传单")
    public Result printSummons(Summons summons) {
        // 数据
        Map<String, String> model = new HashMap<>();
        model.put("courtName", summons.getCourtName());
        model.put("casenumName", summons.getCasenumName());
        model.put("casenumWord", summons.getCasenumWord());
        model.put("casenumCount", summons.getCasenumCount());
        model.put("caseReason", summons.getCaseReason());
        model.put("calledPerson", summons.getCalledPerson());
        model.put("calledAddress", summons.getCalledAddress());
        model.put("calledThing", summons.getCalledThing());
        model.put("arrivalsYear", summons.getArrivalsYear());
        model.put("arrivalsMonth", summons.getArrivalsMonth());
        model.put("arrivalsDay", summons.getArrivalsDay());
        model.put("arrivalsHour", summons.getArrivalsHour());
        model.put("arrivalsMinute", summons.getArrivalsMinute());
        model.put("destination", summons.getDestination());
        model.put("judge", summons.getJudge());
        model.put("clerk", summons.getClerk());
        model.put("callYear", summons.getCallYear());
        model.put("callMonth", summons.getCallMonth());
        model.put("callDay", summons.getCallDay());
        Writer out = null;
        OutputStream os = null;
        try {
            // 将数据放入ftl，并转成html
            Template template = configuration.getTemplate("summons.ftl");
            String pathFile = "D:/summons.html";
            File file = new File(pathFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), "utf-8"));
            template.process(model, out);
            out.flush();
            // 生成pdf
            String url = new File(pathFile).toURI().toURL().toString();
            String outputFile = "D:/summons.pdf";
            os = new FileOutputStream(outputFile);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            // 解决中文问题
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont("C:/windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.layout();
            renderer.createPDF(os);

            // 调用打印机进行打印
            printService.print(outputFile);
            return new Result(Result.ReturnValue.SUCCESS, "打印成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.ReturnValue.FAILURE, "打印失败！");
        } finally {
            // 关闭流
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
