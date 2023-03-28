package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BankAccount;
import dto.Customer;


@WebServlet("/fetchactiveaccount")
public class FetchActiveAccount extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Customer customer= (Customer)req.getSession().getAttribute("Customer");

	if(customer==null)
	{
		resp.getWriter().print("<h1>Session Expired Login Again</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
	else {
	List<BankAccount>list=customer.getAccounts();
	List<BankAccount>list2=new ArrayList<BankAccount>();
	
	
	for(BankAccount account:list2) {
		if(account.isStatus()) {
			list2.add(account);
		}
	}
	
	req.setAttribute("list", customer);
	req.getRequestDispatcher("Accounts.jsp").include(req, resp);
}
}}
