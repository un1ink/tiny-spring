package cn.un1ink.springframework.aop.aspectj;

import cn.un1ink.springframework.aop.Pointcut;
import cn.un1ink.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/6
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public AspectJExpressionPointcutAdvisor(){

    }


    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setPointcut(AspectJExpressionPointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
