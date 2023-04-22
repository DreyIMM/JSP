package com.mangement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.mangement.bean.User;
import com.mangement.dao.UserDao;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDAO = new UserDao();

	public UserServlet() {
		super();
	}

	private User getUser(HttpServletRequest request) {
		User user = new User();
		user.id = Integer.parseInt(request.getParameter("id"));
		user.nome = request.getParameter("nome");
		user.idade = Integer.parseInt(request.getParameter("idade"));
		user.matricula = request.getParameter("matricula");
		return user;
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		if(acao==null) acao="listar";
		acao = acao.trim();

		System.out.println("acao recebida: " + acao);

		switch(acao) {
		
			case "incluir":
	
			     userDAO.create(getUser(request));
			     request.setAttribute("lista", userDAO.obterTodos());
			     
				break;
				
			case "formAlterar":
				
				request.setAttribute("dado", userDAO.obter(Integer.parseInt(request.getParameter("id"))));
				break;	
				
			case "alterar":
	
				userDAO.update(getUser(request));
				request.setAttribute("lista", userDAO.obterTodos());
				
				break;
				
			case "excluir":
				
				userDAO.remove(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("lista", userDAO.obterTodos());
								
				
			break;
			default:
				request.setAttribute("lista", userDAO.obterTodos());	
		}
		
		
		String paginaDestino = 
			(acao.equals("formIncluir")||acao.equals("formAlterar"))?
			"formularioAdd.jsp":"listarUsuario.jsp";
		
		request.getRequestDispatcher(paginaDestino)
		       .forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		    doGet(request, response);
		    
	}
	

}
