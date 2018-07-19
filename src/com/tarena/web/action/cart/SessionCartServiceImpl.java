package com.tarena.web.action.cart;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.ProductDAO;

public class SessionCartServiceImpl implements CartService{
	private Map<Integer, CartItem> store = new HashMap<Integer, CartItem>();
	
	public SessionCartServiceImpl(){
		//���session���Ѵ��ڹ��ﳵ����ָ�store
		Map<String,Object> session = ActionContext.getContext().getSession();
		SessionCartServiceImpl cart = (SessionCartServiceImpl) session.get("s_cart");
		if(cart != null){
			this.store = cart.store;
		}
	}
	
	public void buy(int id) throws Exception {
		if(store.containsKey(id)){
			//������ﳵ���Ѵ��ڣ���Ʒ����+1
			CartItem ci = store.get(id);
			ci.setNum(ci.getNum()+1);
		}else{
			//��������ڣ�������ݿ����ҳ���Ӧ��Ʒ����ӽ����ﳵ
			CartItem ci = new CartItem();
			ProductDAO pDao = DAOFactory.getProductDAO();
			ci.setPro(pDao.findById(id));
			store.put(id, ci);
		}
		
	}

	public void delete(int id) {
		if(store.containsKey(id)){
			store.get(id).setDelete(true);
		}
	}

	/**
	 * delete=true������ɾ����Ʒ�б�
	 * delete=false����ȷ�Ϲ����б�
	 * @param delete
	 * @return
	 */
	public List<CartItem> getItems(boolean delete) {
		List<CartItem> cis = new ArrayList<CartItem>();
		for(CartItem ci : store.values()){
			if(ci.isDelete()==delete){
				cis.add(ci);
			}
		}
		return cis;
	}

	/**
	 * �ָ�
	 */
	public void recovery(int id) {
		if(store.containsKey(id)){
			store.get(id).setDelete(false);
		}
	}
	
	/**
	 * ��չ��ﳵ
	 */
	public void clearCart(){
		CartFactory.removeCart(CartFactory.SESSION_TYPE);
	}

	/**
	 * ͳ��ȷ�Ϲ�����Ʒ�ܽ��
	 * flag true:ͳ��fixed_price,false:ͳ��dang_price
	 */
	public double total(boolean flag) {
		double totalPrice = 0.0;
			if(flag){
				for(CartItem ci : getItems(false)){
					totalPrice += ci.getNum()*ci.getPro().getFixed_price();
				}
			}else{
				for(CartItem ci : getItems(false)){
					totalPrice += ci.getNum()*ci.getPro().getDang_price();
				}
			}
			totalPrice = Number2(totalPrice);
		return totalPrice;
	}

	/**
	 * ����id���²�Ʒ����
	 */
	public void update(int id, int num) {
		if(store.containsKey(id)){
			store.get(id).setNum(num);
		}
	}

	public Map<Integer, CartItem> getStore() {
		return store;
	}

	/**
	 * ��double�����ֱ�����λС��
	 * @param pDouble
	 * @return
	 */
	private double Number2(double pDouble) {
		BigDecimal bd = new BigDecimal(pDouble);
		BigDecimal bd1 = bd.setScale(2, bd.ROUND_HALF_UP);
		pDouble = bd1.doubleValue();

		return pDouble;
	}
	
	
}
