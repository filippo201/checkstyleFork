package com.puppycrawl.tools.checkstyle.ant;


import java.util.List;
import com.puppycrawl.tools.checkstyle.ant.CheckstyleAntTask.Property;
import java.util.ArrayList;
import java.io.File;
import java.util.Properties;
import java.io.InputStream;
import java.nio.file.Files;
import java.io.IOException;
import org.apache.tools.ant.BuildException;
import java.util.Map;
import java.util.Map;

public class CheckstyleAntTaskProduct implements Cloneable{private final List<Property> overrideProps=new ArrayList<>();private File properties;public List<Property> getOverrideProps(){return overrideProps;}public void setProperties(File properties){this.properties=properties;}/**
 * Create the Properties object based on the arguments specified to the ANT task.
 * @return  the properties for property expansion
 * @throws BuildException  if the properties file could not be loaded.
 */public Properties createOverridingProperties(CheckstyleAntTask checkstyleAntTask){final Properties returnValue=new Properties();if (properties != null){try (InputStream inStream=Files.newInputStream(properties.toPath())){returnValue.load(inStream);} catch (final IOException ex){throw new BuildException("Error loading Properties file '" + properties + "'",ex,checkstyleAntTask.getLocation());}}final Map<String, Object> antProps=checkstyleAntTask.getProject().getProperties();for (Map.Entry<String, Object> entry:antProps.entrySet()){final String value=String.valueOf(entry.getValue());returnValue.setProperty(entry.getKey(),value);}for (Property p:overrideProps){returnValue.setProperty(p.getKey(),p.getValue());}return returnValue;}public Object clone() throws CloneNotSupportedException{return (CheckstyleAntTaskProduct)super.clone();}}