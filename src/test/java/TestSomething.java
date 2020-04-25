import org.shek.smartLearning.pojo.Theorem;
import org.shek.smartLearning.service.TheoremService;
import org.shek.smartLearning.service.impl.TheoremServiceImpl;
import org.shek.smartLearning.util.Problem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TestSomething {

    public static void main(String[] args) {
        TheoremService theoremService = new TheoremServiceImpl();
        List<Theorem> theoremList = theoremService.listRandomWithMastery(5);
        System.out.println(theoremList);
    }
}
