package cn.fintecher.print.service.summons.service.impl;

import cn.fintecher.print.service.summons.service.PrintService;
import org.springframework.stereotype.Service;

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
@Service("printService")
public class PrintImpl implements PrintService {

    public void print(String filePath) throws Exception{
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        try {
            int state = fileChooser.showOpenDialog(null);
            if(state == fileChooser.APPROVE_OPTION){
                File file = new File(filePath);
                //设置属性
                HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
                //设置格式
                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                //查找打印服务
                javax.print.PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
                javax.print.PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
                //显示对话框
                javax.print.PrintService service = ServiceUI.printDialog(null, 200, 200, printService,
                        defaultService, flavor, pras);
                if(service != null){
                    DocPrintJob job = service.createPrintJob();
                    FileInputStream fis = new FileInputStream(file);
                    DocAttributeSet das = new HashDocAttributeSet();
                    Doc doc = new SimpleDoc(fis, flavor, das);
                    job.print(doc, pras);
                    fis.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
