package com.mars.timer.load;

import com.mars.common.annotation.bean.MarsTimer;
import com.mars.common.constant.MarsConstant;
import com.mars.common.constant.MarsSpace;
import com.mars.core.model.MarsBeanClassModel;
import com.mars.core.model.MarsTimerModel;
import com.mars.core.load.LoadHelper;
import com.mars.ioc.factory.BeanFactory;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 加载所有加了MarsTimer注解的bean
 */
public class LoadMarsTimer {

    /**
     * 获取全局存储空间
     */
    private static MarsSpace constants = MarsSpace.getEasySpace();

    /**
     * 加载所有加了MarsTimer注解的对象
     * @throws Exception 异常
     */
    public static void loadMarsTimers() throws Exception {
        /* 获取所有的bean数据 */
        List<MarsBeanClassModel> marsBeansList = LoadHelper.getBeanList();

        List<MarsTimerModel> marsTimerObjects = LoadHelper.getMarsTimersList();

        for(MarsBeanClassModel marsBeanClassModel : marsBeansList) {
            Class<?> cls = marsBeanClassModel.getClassName();
            String beanName = LoadHelper.getBeanName(marsBeanClassModel,cls);
            loadMethods(cls,marsTimerObjects,beanName);
        }
    }

    /**
     * 加载加了MarsTimer注解的方法，并保存
     * @param cls 类
     * @param marsTimerObjects 对象
     * @param beanName bean名称
     *
     * @throws Exception 异常
     */
    private static void loadMethods(Class<?> cls, List<MarsTimerModel> marsTimerObjects,String beanName) throws Exception {
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            MarsTimer marsTimer = method.getAnnotation(MarsTimer.class);
            if(marsTimer != null){
                if(method.getParameterCount() > 0){
                    throw new Exception("有参数的方法不可以添加定时任务，方法名:"+cls.getName()+"."+ method.getName());
                }
                Object beanObject = BeanFactory.getBean(beanName,cls);

                MarsTimerModel marsTimerModel = new MarsTimerModel();
                marsTimerModel.setCls(cls);
                marsTimerModel.setMethodName(method.getName());
                marsTimerModel.setObj(beanObject);
                marsTimerModel.setMethod(method);
                marsTimerModel.setMarsTimer(marsTimer);
                marsTimerObjects.add(marsTimerModel);
            }
        }
        /* 保险起见，重新插入数据 */
        constants.setAttr(MarsConstant.MARS_TIMER_OBJECTS, marsTimerObjects);
    }
}
