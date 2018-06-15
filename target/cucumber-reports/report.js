$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/soumyak/Documents/workspace/BDD_CucumberProject_using_TestNG/src/test/java/Feature_File_With_Maps/Tag_Sheet_Upload.feature");
formatter.feature({
  "line": 2,
  "name": "Tag Sheet Upload Feature",
  "description": "",
  "id": "tag-sheet-upload-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@FunctionalTest"
    }
  ]
});
formatter.scenarioOutline({
  "line": 9,
  "name": "Validate the Tag Sheet Upload Feature in the AdTheorent UAT Platform",
  "description": "",
  "id": "tag-sheet-upload-feature;validate-the-tag-sheet-upload-feature-in-the-adtheorent-uat-platform",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "user logs into the website by entering \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 13,
      "value": "#   | username             | password      |"
    },
    {
      "line": 14,
      "value": "#   | admin@adtheorent.com | AdTheorent155 |"
    }
  ],
  "line": 16,
  "name": "validate the Dashboard page title",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "user selects a campaign by entering the CampaignID in the Search text box",
  "rows": [
    {
      "cells": [
        "CampaignID"
      ],
      "line": 21
    },
    {
      "cells": [
        "Campaign:-162"
      ],
      "line": 22
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "user lands on the Campaign Properties page",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "user expands the Creative Library panel",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "user clicks on the Upload Tag Sheet button to navigate to the Upload Tag Sheet interface",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "clicks on the Cancel button",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "user is redirected to the Campaign Properties page",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "user again clicks on the Upload Tag Sheet button",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "user again navigates to the Upload Tag Sheet interface",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "user clicks on the Submit button without uploading any file",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "user accepts the system-generated alert",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "user uploads the Tag sheet from the specified path",
  "rows": [
    {
      "cells": [
        "path"
      ],
      "line": 44
    },
    {
      "cells": [
        "/Users/soumyak/work/Upload Tag Sheet/INS External AdSafe"
      ],
      "line": 45
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 48,
  "name": "clicks on the Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "user lands on the Draft Creative List page after the file upload",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "user logs out of the Draft Creative List page",
  "keyword": "Then "
});
formatter.examples({
  "line": 55,
  "name": "",
  "description": "",
  "id": "tag-sheet-upload-feature;validate-the-tag-sheet-upload-feature-in-the-adtheorent-uat-platform;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 57,
      "id": "tag-sheet-upload-feature;validate-the-tag-sheet-upload-feature-in-the-adtheorent-uat-platform;;1"
    },
    {
      "cells": [
        "admin@adtheorent.com",
        "AdTheorent155"
      ],
      "line": 58,
      "id": "tag-sheet-upload-feature;validate-the-tag-sheet-upload-feature-in-the-adtheorent-uat-platform;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7512817,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "user opens browser",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user is on login page",
  "keyword": "Then "
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_opens_browser()"
});
formatter.result({
  "duration": 11167233486,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_is_on_login_page()"
});
formatter.result({
  "duration": 4091541494,
  "status": "passed"
});
formatter.scenario({
  "line": 58,
  "name": "Validate the Tag Sheet Upload Feature in the AdTheorent UAT Platform",
  "description": "",
  "id": "tag-sheet-upload-feature;validate-the-tag-sheet-upload-feature-in-the-adtheorent-uat-platform;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@FunctionalTest"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "user logs into the website by entering \"admin@adtheorent.com\" and \"AdTheorent155\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 13,
      "value": "#   | username             | password      |"
    },
    {
      "line": 14,
      "value": "#   | admin@adtheorent.com | AdTheorent155 |"
    }
  ],
  "line": 16,
  "name": "validate the Dashboard page title",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "user selects a campaign by entering the CampaignID in the Search text box",
  "rows": [
    {
      "cells": [
        "CampaignID"
      ],
      "line": 21
    },
    {
      "cells": [
        "Campaign:-162"
      ],
      "line": 22
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "user lands on the Campaign Properties page",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "user expands the Creative Library panel",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "user clicks on the Upload Tag Sheet button to navigate to the Upload Tag Sheet interface",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "clicks on the Cancel button",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "user is redirected to the Campaign Properties page",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "user again clicks on the Upload Tag Sheet button",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "user again navigates to the Upload Tag Sheet interface",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "user clicks on the Submit button without uploading any file",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "user accepts the system-generated alert",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "user uploads the Tag sheet from the specified path",
  "rows": [
    {
      "cells": [
        "path"
      ],
      "line": 44
    },
    {
      "cells": [
        "/Users/soumyak/work/Upload Tag Sheet/INS External AdSafe"
      ],
      "line": 45
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 48,
  "name": "clicks on the Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "user lands on the Draft Creative List page after the file upload",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "user logs out of the Draft Creative List page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "admin@adtheorent.com",
      "offset": 40
    },
    {
      "val": "AdTheorent155",
      "offset": 67
    }
  ],
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_logs_into_the_website_by_entering_username_and_password(String,String)"
});
formatter.result({
  "duration": 10112362464,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.validate_the_Dashboard_page_title()"
});
formatter.result({
  "duration": 10059809919,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_selects_a_campaign_by_entering_the_CampaignID_in_the_Search_text_box(DataTable)"
});
formatter.result({
  "duration": 24337815524,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_lands_on_the_Campaign_Properties_page()"
});
formatter.result({
  "duration": 20044622051,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_expands_the_Creative_Library_panel()"
});
formatter.result({
  "duration": 14162123391,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_clicks_on_the_Upload_Tag_Sheet_button()"
});
formatter.result({
  "duration": 1097798105,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.clicks_on_the_Cancel_button()"
});
formatter.result({
  "duration": 2066596714,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_is_redirected_to_the_Campaign_Properties_page()"
});
formatter.result({
  "duration": 12024214810,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_again_clicks_on_the_Upload_Tag_Sheet_button()"
});
formatter.result({
  "duration": 2091751591,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_again_navigates_to_the_Upload_Tag_Sheet_interface()"
});
formatter.result({
  "duration": 3024124667,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_clicks_on_the_Submit_button_without_uploading_any_file()"
});
formatter.result({
  "duration": 6276816109,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_accepts_the_system_generated_alert()"
});
formatter.result({
  "duration": 5018865731,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_uploads_the_Tag_sheet_from_the_specified_path(DataTable)"
});
formatter.result({
  "duration": 27500310955,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.clicks_on_the_Submit_button()"
});
formatter.result({
  "duration": 5075273398,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_lands_on_the_Draft_Creative_List_page_after_the_file_upload()"
});
formatter.result({
  "duration": 15045817038,
  "status": "passed"
});
formatter.match({
  "location": "AdTheorent_Upload_Tag_Sheet_withMap_Definition.user_logs_out_of_the_Draft_Creative_List_page()"
});
formatter.result({
  "duration": 19126515375,
  "status": "passed"
});
formatter.write("Finished successfully!!!");
formatter.after({
  "duration": 298928,
  "status": "passed"
});
});