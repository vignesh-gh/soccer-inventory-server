package com.soccer_inventory.soccer_inventory.seq;

import org.springframework.stereotype.Service;

@Service
public class ProductSeqGen {
	int min=1;
	int max=9999;
	
	public int 	getSequence() {
		
	    int seqvalue = (int)(Math.random() * (max - min + 1) + min);	    
	    return seqvalue;

	}


}
