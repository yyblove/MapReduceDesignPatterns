package com.yyb.mrdp.summary;

import com.yyb.mrdp.summary.average.AverageTool;
import com.yyb.mrdp.summary.countcounters.CountNumUserByStateTool;
import com.yyb.mrdp.summary.invertedindex.InvertedIndexTool;
import com.yyb.mrdp.summary.medianstddev.v1.MedianStdDevV1Tool;
import com.yyb.mrdp.summary.medianstddev.v2.MedianStdDevV2Tool;
import com.yyb.mrdp.summary.minmaxcount.MinMaxCountTool;
import com.yyb.mrdp.utils.MRDPUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *         2016/6/19.
 */
public class MainApplication {

    private static final String MIN_MAX_COUNT = "minmaxcount";
    private static final String AVERAGE = "average";
    private static final String MEDIAN_STD_DEV_V1 = "medianstddevv1";
    private static final String MEDIAN_STD_DEV_V2 = "medianstddevv2";
    private static final String INVETED_INDEX = "invetedindex";
    private static final String COUNT_COUNTERS = "countcounters";

    public static void main(String[] args) throws Exception {
        try {
            Configuration conf = new Configuration();
            int result = -1;
            switch (args[args.length - 3].toLowerCase()) {
                case MIN_MAX_COUNT:
                    result = ToolRunner.run(conf, new MinMaxCountTool(), args);
                    break;
                case AVERAGE:
                    result = ToolRunner.run(conf, new AverageTool(), args);
                    break;
                case MEDIAN_STD_DEV_V1:
                    result = ToolRunner.run(conf, new MedianStdDevV1Tool(), args);
                    break;
                case MEDIAN_STD_DEV_V2:
                    result = ToolRunner.run(conf, new MedianStdDevV2Tool(), args);
                    break;
                case INVETED_INDEX:
                    result = ToolRunner.run(conf, new InvertedIndexTool(), args);
                    break;
                case COUNT_COUNTERS:
                    result = ToolRunner.run(conf, new CountNumUserByStateTool(), args);
                    break;

            }
            if (result != -1) {
                System.exit(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        MRDPUtils.printOptions(getClassList());
    }

    private static List<String> getClassList() {
        List<String> classList = new ArrayList<>();
        classList.add(MIN_MAX_COUNT);
        classList.add(AVERAGE);
        classList.add(MEDIAN_STD_DEV_V1);
        classList.add(MEDIAN_STD_DEV_V2);
        classList.add(INVETED_INDEX);
        classList.add(COUNT_COUNTERS);
        return classList;
    }

}
