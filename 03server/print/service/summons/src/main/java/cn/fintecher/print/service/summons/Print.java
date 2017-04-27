package cn.fintecher.print.service.summons;

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
@RequestMapping("/print")
public class Print {



    @RequestMapping("/txt")
    public static void print() throws Exception{

//        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
//        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
//        PrintService[] pservices = PrintServiceLookup.lookupPrintServices(flavor, aset);
//        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
//        PrintService service = ServiceUI.printDialog(null, 200, 200, pservices,
//                defaultService, flavor, aset);
//        if (service != null) {
//            try {
//                DocPrintJob pj = service.createPrintJob();
//                aset.add(MediaSizeName.ISO_A4);
//                FileInputStream fis = new FileInputStream("D:/test_print.txt");
//                DocAttributeSet das = new HashDocAttributeSet();
//                Doc doc = new SimpleDoc(fis, flavor, das);
//                pj.print(doc, aset);
//                Thread.sleep(10 * 1000);
//            } catch (FileNotFoundException fe) {
//                fe.printStackTrace();
//            } catch (PrintException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("打印失败");
//        }

        JFileChooser fileChooser = new JFileChooser(); //创建打印作业
        int state = fileChooser.showOpenDialog(null);
        if(state == fileChooser.APPROVE_OPTION){
            File file = new File("D:/test_print.txt"); //获取选择的文件
            //构建打印请求属性集
            HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            //设置打印格式，因为未确定类型，所以选择autosense
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            //查找所有的可用的打印服务
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
            //定位默认的打印服务
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
            //显示打印对话框
            PrintService service = ServiceUI.printDialog(null, 200, 200, printService,
                    defaultService, flavor, pras);
            if(service != null){
                try {
                    DocPrintJob job = service.createPrintJob(); //创建打印作业
                    FileInputStream fis = new FileInputStream(file); //构造待打印的文件流
                    DocAttributeSet das = new HashDocAttributeSet();
                    Doc doc = new SimpleDoc(fis, flavor, das);
                    job.print(doc, pras);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
