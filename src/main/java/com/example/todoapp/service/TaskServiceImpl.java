package com.example.todoapp.service;

import java.util.List;
import java.util.Optional;
 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
 
import com.example.todoapp.entity.Task;
import com.example.todoapp.repository.TaskDao;
 
@Service
public class TaskServiceImpl implements TaskService {
 
  private final TaskDao dao;
 
    public TaskServiceImpl(TaskDao dao) {
        this.dao = dao;
    }
 
  @Override
  public List<Task> findAll() {
    return this.dao.findAll();
  }
 
  @Override
  public Optional<Task> getTask(int id) {
    try {
      return this.dao.findById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new TaskNotFoundException("指定されたタスクが存在しません");
    }
  }
 
  @Override
  public void insert(Task task) {
    this.dao.insert(task);
  }
 
  @Override
  public void update(Task task) {
    // id が無ければ例外スロー
    if (this.dao.update(task) == 0) {
      throw new TaskNotFoundException("更新するタスクが存在しません");
    }
  }
 
  @Override
  public void deleteById(int id) {
    // id が無ければ例外スロー
    if (this.dao.deleteById(id) == 0) {
      throw new TaskNotFoundException("削除するタスクが存在しません");
    }
  }
 
  @Override
  public List<Task> findByType(int typeId) {
    // TODO Auto-generated method stub
    return null;
  }
}