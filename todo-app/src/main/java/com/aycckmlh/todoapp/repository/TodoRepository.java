package com.aycckmlh.todoapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.aycckmlh.todoapp.domain.TodoItem;

@Repository
public class TodoRepository {
	private Integer idCounter = 0;
	private List<TodoItem> todoItems = new ArrayList<>();
	public List<TodoItem> fetchAllTodoItems(){
		
		if(todoItems.size() == 0) {
			TodoItem item1 =new TodoItem();
			item1.setId(idCounter++);
			item1.setIsDone(true);
			item1.setTask("Task #1");
			//BURADA BİR YAPIALCAKLAR LİSTESİ OLUŞTURUYORUZ
			
			todoItems.add(item1);
			//VERİLERİMİZİ ŞİMDİLİK HAFIZAMIZDA(DATABASE S HERE)
		}
		return todoItems; //BASİT OLAN ÖGELERİ GERİ DÖNECEK
		
	}
	public TodoItem save (TodoItem todoItem) {
		todoItem.setId(idCounter++);
		todoItems.add(todoItem);
		return todoItem;
	}
	public void delete(Integer id) {
		todoItems = todoItems.stream()
							 .filter(todoItem -> !todoItem.getId().equals(id))
							 .collect(Collectors.toList());
	}
	

}
