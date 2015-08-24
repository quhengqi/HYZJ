package com.hengyuan.action;
/**
 * author:quhengqi
 * version:2.0
 * 
 */
import java.util.List;


import com.hengyuan.service.GoodServiceImpl;
import com.hengyuan.vo.Category;
import com.hengyuan.vo.Good;
import com.hengyuan.vo.Page;
import com.hengyuan.vo.User;
/**
 * 实现商品服务功能
 * 查看相应类别商品,查看商品详情
 * 查看收藏,添加收藏,删除收藏
 * */
public class GoodAction extends ActionTemplate{

	/**
	 * 默认UID
	 */
	private static final long serialVersionUID = 1770696991407748511L;
	/**
	 * 商品服务类声明
	 * */
	private GoodServiceImpl gservice;
	/**
	 * 商品链表，用来存放相应类型的商品
	 * */
	private List<Good> glist;
	/**
	 * 商品容器
	 * */
	private Good good;
	/**
	 * 商品种类容器
	 * */
	private Category category;
	/**
	 * 用户收藏链表
	 * */
	private List<Good> wishlist;
	/**
	 * 页面变量容器
	 * */
	private Page page;
	/**
	 * 关键字搜索
	 * */
	private String keyWord;
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Good> getWishlist() {
		return wishlist;
	}
	public void setWishlist(List<Good> wishlist) {
		this.wishlist = wishlist;
	}
	public void setGservice(GoodServiceImpl gservice) {
		this.gservice = gservice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Good> getGlist() {
		return glist;
	}
	public void setGlist(List<Good> glist) {
		this.glist = glist;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	/**
	显示相应种类的商品
	*/
	public String showgood() throws Exception {
		// TODO Auto-generated method stub		
		this.clearMessages();
		setGlist(gservice.queryGoodList(getCategory()));
		if(getGlist().isEmpty()){
			this.addActionMessage("暂无商品");
		}
		getSession().put("ct", getCategory());//分页需要
		return "show";
	}
	/**
	 * 查询商品详细信息
	 * */
	public String querygood() throws Exception{
		// TODO Auto-generated method stub
		setGood(gservice.queryGood(good));

		return "showProduct";
	}
	/**
	 * 搜索商品
	 * */
	public String searchgood() throws Exception{
		// TODO Auto-generated method stub
		clearMessages();
		setGlist(gservice.searchGoodList(keyWord));
		if(getGlist().isEmpty()){
			this.addActionMessage("抱歉,暂无关键字为"+keyWord+"的商品");
		}
		return "search";
	}
	/**
	 * 查看收藏列表
	 * */
	public String showWishList() throws Exception {
		setWishlist(gservice.queryWishList((User) getSession().get("user")));
		return "wishList";
	}
	/**
	 * 添加收藏
	 * */
	public String addToWishList() throws Exception
	{
		gservice.addToWishList((User) getSession().get("user"), good);
		return showWishList();
	}
	/**
	 * 删除收藏
	 * */
	public String delFromWishList() throws Exception{
		gservice.delFromWishList((User) getSession().get("user"), good);
		return showWishList();
	}
}
