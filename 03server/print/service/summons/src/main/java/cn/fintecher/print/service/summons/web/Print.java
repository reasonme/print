package cn.fintecher.print.service.summons.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: wuzhanhui
 * @Description: 打印功能实现
 * @Date 2017/4/27.
 */
@RestController
@RequestMapping("/api/print")
@Api(value = "打印相关",description = "打印相关")
public class Print {



    @GetMapping("/summons")
    @ApiOperation(value = "打印操作",notes = "打印操作")
    public void print() throws Exception{

        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        try {
            int state = fileChooser.showOpenDialog(null);
            if(state == fileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                //设置属性
                HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
                //设置格式
                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                //查找打印服务
                PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
                PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
                //显示对话框
                PrintService service = ServiceUI.printDialog(null, 200, 200, printService,
                        defaultService, flavor, pras);
                if(service != null){
                    DocPrintJob job = service.createPrintJob();
                    FileInputStream fis = new FileInputStream(file);
                    DocAttributeSet das = new HashDocAttributeSet();
                    Doc doc = new SimpleDoc(fis, flavor, das);
                    job.print(doc, pras);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
