package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtendReport implements ITestListener {

    @Override
   public void onTestStart(ITestResult result){
   }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Attach Pass message to Report");
    }
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Take screenshoot and attach to Report");
    }


}
