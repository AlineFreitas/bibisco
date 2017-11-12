/*
 * Copyright (C) 2014-2017 Andrea Feccomandi
 *
 * Licensed under the terms of GNU GPL License;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/gpl-2.0.html
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY.
 * See the GNU General Public License for more details.
 *
 */
angular.
  module('bibiscoApp').
  component('scenedetail', {
    templateUrl: 'components/chapters/scene-detail.html',
    controller: SceneDetailController,
    bindings: {

    }
  });

function SceneDetailController($location, $rootScope, $routeParams,
  ChapterService) {
  var self = this;

  self.$onInit = function() {

    $rootScope.$emit('SHOW_ELEMENT_DETAIL');

    self.chapter = ChapterService.getChapter($routeParams.chapterid);
    self.scene = ChapterService.getScene($routeParams.sceneid);
    self.title = '#' + self.scene.position + ' ' + self.scene.title;

    self.breadcrumbitems = [];
    self.breadcrumbitems.push({
      label: 'jsp.projectFromScene.nav.li.chapters',
      href: '/project/chapters'
    });
    self.breadcrumbitems.push({
      label: '#' + self.chapter.position + ' ' + self.chapter.title,
      href: '/chapters/' + self.chapter.$loki
    });
    self.breadcrumbitems.push({
      label: self.scene.title
    });

    self.editmode = false;
  };

  self.back = function() {
    $location.path('/chapters/' + self.chapter.$loki);
  };

  self.changerevision = function(action, revision) {
    if (action == 'new-from-actual') {
      self.scene = ChapterService.createSceneRevisionFromActual($routeParams.sceneid);
      self.editmode = true;
    } else if (action == 'new-from-scratch') {
      self.scene = ChapterService.createSceneRevisionFromScratch($routeParams
        .sceneid);
      self.editmode = true;
    } else if (action == 'change') {
      self.scene = ChapterService.changeSceneRevision($routeParams.sceneid,
        revision);
    } else if (action == 'delete') {
      self.scene = ChapterService.deleteActualSceneRevision($routeParams.sceneid);
    }
  };

  self.changeStatus = function(status) {
    self.scene.status = status;
    ChapterService.updateScene(self.scene);
  };

  self.changetitle = function() {
    $location.path('/chapters/' + self.chapter.$loki + '/scenes/' + self.scene
      .$loki + '/title');
  };

  self.delete = function() {
    ChapterService.removeScene(self.scene.$loki);
    $location.path('/chapters/' + self.chapter.$loki);
  };

  self.save = function() {
    ChapterService.updateScene(self.scene);
  };

  self.tags = function() {
    $location.path('/chapters/' + self.chapter.$loki + '/scenes/' + self.scene
      .$loki + '/tags');
  };
}
