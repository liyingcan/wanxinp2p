package cn.itcast.wanxinp2p.common.util;
@FunctionalInterface
public interface BeanCopyCallBackUtil<S, T> {
	 /**
     * 定义默认回调方法
     * @param t
     * @param s
     */
    void callBack(S t, T s);
}
