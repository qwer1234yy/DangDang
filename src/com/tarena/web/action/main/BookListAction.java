package com.tarena.web.action.main;

import java.util.List;

import com.tarena.dao.CategoryDAO;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.ProductDAO;
import com.tarena.entity.Category;
import com.tarena.entity.Product;

public class BookListAction extends PageAction {
	private int c1;// ��Ŀ¼id
	private int c2;// ��Ŀ¼id

	private int totalPnum;// ��Ʒ����
	private List<Category> cats;// Ŀ¼
	private List<Product> books;// �鱾չʾ

	public String execute() throws Exception {
		int pnum = 0;
		CategoryDAO cDao = DAOFactory.getCategoryDAO();
		cats = cDao.findByParentId(c1);

		for (Category c : cats) {
			totalPnum += c.getPnum();
			if (c.getId() == c2) {
				pnum = c.getPnum();// ��ȡ��ǰĿ¼�µ���Ʒ��
			}
		}
		ProductDAO pDao = DAOFactory.getProductDAO();
		int begin = (page - 1) * size;
		books = pDao.findByCatId(c2, begin, size);

		// �����Ŀ¼����ҳ��
		if (pnum == 0) {
			maxPage = 1;
		} else if (pnum % size == 0) {
			maxPage = pnum / size;
		} else {
			maxPage = pnum / size + 1;
		}

		return "list";
	}

	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public int getTotalPnum() {
		return totalPnum;
	}

	public void setTotalPnum(int totalPnum) {
		this.totalPnum = totalPnum;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

	public List<Product> getBooks() {
		return books;
	}

	public void setBooks(List<Product> books) {
		this.books = books;
	}

}
