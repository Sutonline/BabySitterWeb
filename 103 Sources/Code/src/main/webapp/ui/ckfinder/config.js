/*
Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
For licensing, see license.txt or http://cksource.com/ckfinder/license
*/

CKFinder.customConfig = function( config )
{
	// Define changes to default configuration here.
	// For the list of available options, check:
	// http://docs.cksource.com/ckfinder_2.x_api/symbols/CKFinder.config.html

	// Sample configuration options:
	// config.uiColor = '#BDE31E';
	// config.language = 'fr';
	// config.removePlugins = 'basket';
	
	//add ckfinder support
	config.filebrowserBrowseUrl = '/BabySitterWeb/ckfinder/ckfinder.html';
	config.filebrowserImageBrowseUrl = '/BabySitterWeb/ckfinder/ckfinder.html?Type=Images';
	config.filebrowserUploadUrl = '/BabySitterWeb/ui/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	config.filebrowserImageUploadUrl = '/BabySitterWeb/ui/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';

};
