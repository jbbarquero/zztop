package org.apache.naming.factory;

import java.net.URL;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

public class URLFactory implements ObjectFactory {

	public Object getObjectInstance(Object obj, Name name, Context nameCtx,
			Hashtable<?, ?> environment) throws Exception {
		Reference ref = (Reference) obj;
		String url = (String) ref.get("url").getContent();
		return new URL(url);
	}

}
