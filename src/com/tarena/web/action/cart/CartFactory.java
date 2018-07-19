package com.tarena.web.action.cart;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class CartFactory {
	public final static String SESSION_TYPE = "session";
	public final static String DB_TYPE = "abc";

	public static CartService getCart(String type) {
		if (type.equals(DB_TYPE)) {
			return new SessionCartServiceImpl();
		} else {
			// Ĭ�Ϸ��ػ���session��ʽ��CartService
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			CartService cart = (CartService) session.get("s_cart");
			if (cart == null) {
				cart = new SessionCartServiceImpl();
				session.put("s_cart", cart);
			}
			return cart;
		}
	}

	public static void removeCart(String type) {
		if (type.equals(DB_TYPE)) {
			// �����ݿ��ж�Ӧ���ﳵ����Ϣɾ��
		} else {
			// Ĭ��ɾ��session�еĹ��ﳵ��Ϣ
			ActionContext.getContext().getSession().remove("s_cart");
		}
	}
}
