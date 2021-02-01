package pacakge.project.topic;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;


@Service
public class Topicservice2 {

	
	
	@Async
	public CompletableFuture<Integer> asyncGetOfftrackCounts() {
		
	System.out.println("^^^^^^^^^^6from asyncGetOfftrackCounts " + Thread.currentThread().getName()); 
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new AsyncResult<>(10).completable(); 
	}

	@Async
	public CompletableFuture<Integer> asyncGetStudents() {
	System.out.println("from asyncGetOfftrackCounts ^^^^^^^^^^"+ Thread.currentThread().getName()); 
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return  new AsyncResult<>(20).completable(); 
	}
}
