//package dictionary;
import dictionary.PrimeSequence;

//import dictionary.Nonsense;

//import test.Randomizer;
//import test.*;
import dictionary.AbstractHashTable;
import dictionary.Loader;
import java.util.Random;

import java.lang.Math;

//
import java.io.File;
//
import java.lang.reflect.Constructor;

public class SearchTest
	{
	private static AbstractHashTable createTable(final String className, final int tableSize) throws Exception 
		{ 
		final Class<? extends AbstractHashTable> tableClass = Class.forName(className).asSubclass(AbstractHashTable.class);
		final Constructor<? extends AbstractHashTable> intConstructor = tableClass.getConstructor(int.class);
		return intConstructor.newInstance(tableSize);
		}

	public static void main(final String[] args) throws Exception 
		{
		int length = Integer.parseInt(args[1]);
		PrimeSequence prime = new PrimeSequence(length);
		int tableSize = prime.next();
		final AbstractHashTable table = createTable(args[0], tableSize);
		final Loader loader = new Loader(table);
		
		loader.load(new File("./data/" + args[2]));
		final Randomizer no = new Randomizer(table.getWords());
		final Nonsense non = new Nonsense(3, 10);
		table.resetProbeCount();
	
		int sampleSize = Integer.parseInt(args[3]);
		int repeats = Integer.parseInt(args[4]);
		int p=0;
		for (int k = 0; k<repeats; k ++)		
			{
			//System.out.println("yes");
			
			for (int q = 0; q<Math.round(sampleSize*0.8); q++)
				{
				if (no.hasNext())
					{
					table.getDefinitions(no.next().toString());
					p = q;
					}
				}
			while (p < sampleSize)
				{
				table.getDefinitions(non.next());
				p++;
				}
			p = 0;
			//System.out.println("Probe count: " + table.getProbeCount());
			
			}
		
		double average = (double)table.getProbeCount()/(double)repeats;
		System.out.println("");
		//System.out.println(repeats);
		System.out.println("testing " + args[0] + " for search ...");
		System.out.println("Probe count: " + table.getProbeCount());
		System.out.println("Probe count average: " + average);
		
		//System.out.println("Table size: " + tableSize);
		//System.out.println("table.size(): " + table.size());
		System.out.println("tableSize: " + tableSize);
		//System.out.println("Load factor: " + (entries)/(dSize));
		System.out.println("Load factor: " + table.loadFactor());
		
		}
	}
