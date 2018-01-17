package cn.itcast.jx.util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.jx.common.SysConstant;


 
/**
 * 分页辅助类：对分页的基本数据进行一个简单的封装
 * 用来传递分页参数和查询参数params
 */
public class Page<T> {
    private int pageNo = 1;							//页码，默认是第一页
    private int pageSize = SysConstant.PAGE_SIZE;	//每页显示的记录数，默认是10
    private int totalRecord;						//总记录数
    private int totalPage;							//总页数
    private List<T> results;						//对应的当前页记录
    private Map<String, Object> params = new HashMap<String, Object>();		//其他的参数我们把它分装成一个Map对象
 
    public int getPageNo() {
       return pageNo;
    }
 
    public void setPageNo(int pageNo) {
       this.pageNo = pageNo;
    }
 
    public int getPageSize() {
       return pageSize;
    }
 
    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
    }
 
    public int getTotalRecord() {
       return totalRecord;
    }
 
    public void setTotalRecord(int totalRecord) {
       this.totalRecord = totalRecord;
       //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
       int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
       this.setTotalPage(totalPage);
    }
 
    public int getTotalPage() {
       return totalPage;
    }
 
    public void setTotalPage(int totalPage) {
       this.totalPage = totalPage;
    }
 
    public List<T> getResults() {
       return results;
    }
 
    public void setResults(List<T> results) {
       this.results = results;
    }
   
    public Map<String, Object> getParams() {
       return params;
    }
   
    public void setParams(Map<String, Object> params) {
       this.params = params;
    }
 
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("Page [pageNo=").append(pageNo).append(", pageSize=").append(pageSize).append(", results=").append(results).append(", totalPage=").append(totalPage).append(", totalRecord=").append(totalRecord).append("]");
       return builder.toString();
    }
 
	/* 页面链接 */
    public String url;		//分页按钮中的转向链接
    public void setUrl(String url) {
    	this.url = url;
    }
    
    public String getUrl() {
		return url;
	}

	public String links;
    
    
    /**
     * 值栈的取值调用的是get方法，因为links有getter方法，所以那个工具条是在getter方法中拼接的
     * 第1页 / 共1页  总共8条记录 每页10条记录 [首页] [上一页] [下一页] [末页] 
     * 
     * @return
     */
	public String getLinks() {
		String str = "";
		//第1页 / 共1页  总共8条记录 每页10条记录
		str+="第"+pageNo+"页 / 共"+totalPage+"页  总共"+totalRecord+"条记录 每页"+pageSize+"条记录";
		
		//在分页工具条中存放一个隐藏域，这个隐藏域用来存储将要去的页码信息
		//name应该写page.pageNo，表明提交给的是page对象里面的pageNo属性
		str+="<input type='hidden' name='page.pageNo' id='pageNo' value='1'>";
		
		//首页
		str+="<a href='#' onclick=\"turnPage('"+url+"',1)\">[首页]</a>";
		//上一页
		int no = pageNo-1>1?pageNo-1:1;
		str+="<a href='#' onclick=\"turnPage('"+url+"',"+no+")\">[上一页]</a>";
		//下一页
		no = pageNo+1>totalPage?totalPage:pageNo+1;
		str+="<a href='#' onclick=\"turnPage('"+url+"',"+no+")\">[下一页]</a>";
		//末页
		str+="<a href='#' onclick=\"turnPage('"+url+"',"+totalPage+")\">[末页]</a>";
		
		return str;
	}
	

}